// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'address.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Address _$AddressFromJson(Map<String, dynamic> json) => Address(
      json['index'] as String,
      json['country'] as String,
      json['region'] as String,
      json['district'] as String,
      json['city'] as String,
      json['street'] as String,
      json['numberOfHouse'] as String,
      json['corpus'] as String,
      json['apartment'] as String,
    );

Map<String, dynamic> _$AddressToJson(Address instance) => <String, dynamic>{
      'index': instance.index,
      'country': instance.country,
      'region': instance.region,
      'district': instance.district,
      'city': instance.city,
      'street': instance.street,
      'numberOfHouse': instance.numberOfHouse,
      'corpus': instance.corpus,
      'apartment': instance.apartment,
    };
