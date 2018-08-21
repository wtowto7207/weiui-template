//
//  WeiuiCityPickerModule.m
//  WeexTestDemo
//
//  Created by apple on 2018/6/8.
//  Copyright © 2018年 TomQin. All rights reserved.
//

#import "WeiuiCityPickerModule.h"
#import "LZCityPickerController.h"
#import "DeviceUtil.h"

@implementation WeiuiCityPickerModule

WX_EXPORT_METHOD(@selector(select:callback:))

- (void)select:(NSDictionary*)params callback:(WXModuleKeepAliveCallback)callback
{
    [LZCityPickerController showPickerInViewController:[DeviceUtil getTopviewControler] selectBlock:^(NSString *address, NSString *province, NSString *city, NSString *area) {
        
        NSLog(@"%@--%@--%@--%@",address,province,city,area);
        
        callback(@{@"province":province, @"city":city, @"area":area}, YES);
    }];
}


@end
