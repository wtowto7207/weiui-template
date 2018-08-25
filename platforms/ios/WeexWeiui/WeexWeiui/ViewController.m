//
//  ViewController.m
//  WeexWeiui
//
//  Created by 高一 on 2018/8/15.
//

#import "ViewController.h"

#import "WeexSDK.h"
#import "WeexSDKManager.h"
#import "WXMainViewController.h"
#import "WeiuiRongcloudManager.h"

@interface ViewController ()

@end

@implementation ViewController

WXMainViewController *homeController;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    NSString *bundleUrl = [self getBundleUrl];
    
    [WeexSDKManager sharedIntstance].weexUrl = bundleUrl;
    
    dispatch_async(dispatch_get_main_queue(), ^{
        [[WeexSDKManager sharedIntstance] setup];
        
        [self initRongcloud];
        
        homeController = [[WXMainViewController alloc] init];
        homeController.url = bundleUrl;
        homeController.statusBarType = @"normal";
        homeController.backgroundColor = @"#f4f8f9";
        homeController.params = @{};
        homeController.isDisSwipeBack = YES;
        homeController.cache = 1000;
        homeController.pageName = @"FirstPage";
        
        [[UIApplication sharedApplication] delegate].window.rootViewController =  [[WXRootViewController alloc] initWithRootViewController:homeController];
    });
    
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

//首页重新加载
- (void)loadUrl: (NSString*)url {
    [WeexSDKManager sharedIntstance].weexUrl = url;
    [homeController setHomeUrl: url];
    [homeController refreshPage];
}

//获取首页地址
- (NSString*)getBundleUrl {
    NSString *filePath = [[ NSBundle mainBundle ] pathForResource : @"bundlejs/weiui/config" ofType : @"json" ];
    NSData *fileData = [[ NSData alloc ] initWithContentsOfFile :filePath];
    NSDictionary *jsonObject = [NSJSONSerialization JSONObjectWithData:fileData options:kNilOptions error:nil];
    NSMutableDictionary *jsonData = [NSMutableDictionary dictionaryWithDictionary:jsonObject];
    NSString *homePage = [NSString stringWithFormat:@"%@", jsonData[@"homePage"]];
    if (!homePage.length) {
        homePage = [NSString stringWithFormat:@"file://%@/bundlejs/weiui/index.js",[NSBundle mainBundle].bundlePath];
    }
    return homePage;
}

//初始化融云
- (void)initRongcloud {
    NSString *filePath = [[ NSBundle mainBundle ] pathForResource : @"bundlejs/weiui/config" ofType : @"json" ];
    NSData *fileData = [[ NSData alloc ] initWithContentsOfFile :filePath];
    NSDictionary *jsonObject = [NSJSONSerialization JSONObjectWithData:fileData options:kNilOptions error:nil];
    NSMutableDictionary *jsonData = [NSMutableDictionary dictionaryWithDictionary:jsonObject];
    NSMutableDictionary *rongim = [[jsonData objectForKey:@"rongim"] objectForKey:@"ios"];
    NSString *enabled = [NSString stringWithFormat:@"%@", rongim[@"enabled"]];
    //
    if ([enabled containsString:@"1"] || [enabled containsString:@"true"]) {
        NSString *appKey = [NSString stringWithFormat:@"%@", rongim[@"appKey"]];
        NSString *appSecret = [NSString stringWithFormat:@"%@", rongim[@"appSecret"]];
        [WeexSDKManager sharedIntstance].rongKey = appKey;
        [WeexSDKManager sharedIntstance].rongSec = appSecret;
        [[WeiuiRongcloudManager sharedIntstance] init:appKey appSecret:appSecret];
    }
}

@end
