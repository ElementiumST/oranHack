// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'person.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Person _$PersonFromJson(Map<String, dynamic> json) => Person(
      json['firstName'] as String,
      json['secondName'] as String,
      json['lastName'] as String,
      json['parentStatus'] as String,
      json['citizenCountry'] as String,
      json['birthday'] as String,
      json['passport'],
      Address.fromJson(json['address'] as Map<String, dynamic>),
      json['snils'] as String,
      json['phoneNumber'] as String,
      json['email'] as String,
      (json['childs'] as List<dynamic>).map((e) => e as String).toList(),
    );

Map<String, dynamic> _$PersonToJson(Person instance) => <String, dynamic>{
      'firstName': instance.firstName,
      'secondName': instance.secondName,
      'lastName': instance.lastName,
      'parentStatus': instance.parentStatus,
      'citizenCountry': instance.citizenCountry,
      'birthday': instance.birthday,
      'passport': instance.passport,
      'address': instance.address,
      'snils': instance.snils,
      'phoneNumber': instance.phoneNumber,
      'email': instance.email,
      'childs': instance.childs,
    };
