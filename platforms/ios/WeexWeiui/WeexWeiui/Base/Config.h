//
//  Config.h
//  WeexWeiui
//
//  Created by 高一 on 2018/9/27.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface Config : NSObject

+ (NSMutableDictionary *) get;
+ (void) clear;
+ (NSString *) getString:(NSString*)key;
+ (NSMutableDictionary *) getObject:(NSString*)key;
+ (NSString *) getHome;
+ (BOOL) isConfigDataIsDist;

+ (NSString *) getPath:(NSString*)name;
+ (NSInteger) getLocalVersion;
+ (NSString*)getLocalVersionName;
+ (BOOL) isFileExists:(NSString*)path;
+ (BOOL) isFile:(NSString*)path;
+ (BOOL) isDir:(NSString*)path;
+ (NSString *) getyyyMMddHHmmss;
+ (NSString *) MD5ForLower32Bate:(NSString *)str;
+ (NSString *) getMiddle:(NSString *)string start:(nullable NSString *)startString to:(nullable NSString *)endString;

@end

NS_ASSUME_NONNULL_END

