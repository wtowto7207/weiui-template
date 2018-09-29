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
#import "Config.h"
#import "Cloud.h"

@interface ViewController ()

@property (nonatomic, assign) BOOL ready;

@end

@implementation ViewController

WXMainViewController *homeController;

- (void) viewDidLoad {
    [super viewDidLoad];
    
    NSString *bundleUrl = [Config getHome];
    
    [WeexSDKManager sharedIntstance].weexUrl = bundleUrl;
    
    dispatch_async(dispatch_get_main_queue(), ^{
        [[WeexSDKManager sharedIntstance] setup];
        dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)([Cloud welcome:nil] * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
            self.ready = YES;
            homeController = [[WXMainViewController alloc] init];
            homeController.url = bundleUrl;
            homeController.statusBarType = @"normal";
            homeController.backgroundColor = @"#f4f8f9";
            homeController.params = @{};
            homeController.isDisSwipeBack = YES;
            homeController.cache = 1000;
            homeController.pageName = @"FirstPage";
            homeController.statusBlock = ^(NSString *status) {
                if ([status isEqualToString:@"create"]) {
                    [Cloud appData];
                }
            };
            [[UIApplication sharedApplication] delegate].window.rootViewController =  [[WXRootViewController alloc] initWithRootViewController:homeController];
        });
    });
}

- (void) loadUrl:(NSString*) url {
    [WeexSDKManager sharedIntstance].weexUrl = url;
    [homeController setHomeUrl: url];
    [homeController refreshPage];
}

- (BOOL) isReady {
    return self.ready;
}

@end
