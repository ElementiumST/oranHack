// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'passport.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Passport _$PassportFromJson(Map<String, dynamic> json) => Passport(
      json['series'] as int,
      json['number'] as int,
      json['dateOfGetting'] as String,
      json['issueName'] as String,
      json['isRussianPassport'] as String,
    );

Map<String, dynamic> _$PassportToJson(Passport instance) => <String, dynamic>{
      'series': instance.series,
      'number': instance.number,
      'dateOfGetting': instance.dateOfGetting,
      'issueName': instance.issueName,
      'isRussianPassport': instance.isRussianPassport,
    };
