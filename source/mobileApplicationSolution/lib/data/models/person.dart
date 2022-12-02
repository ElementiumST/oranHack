import 'package:dooking/data/models/Person.dart';
import 'package:json_annotation/json_annotation.dart';

import 'Passport.dart';
import 'address.dart';

part 'person.g.dart';

@JsonSerializable()
class Person {
  String firstName;
  String secondName;
  String lastName;
  String parentStatus;
  String citizenCountry;
  String birthday;
  Passport passport;
  Address address;
  String snils;
  String phoneNumber;
  String email;
  List<String> childs;


  Person(
      this.firstName,
      this.secondName,
      this.lastName,
      this.parentStatus,
      this.citizenCountry,
      this.birthday,
      this.passport,
      this.address,
      this.snils,
      this.phoneNumber,
      this.email,
      this.childs);

  factory Person.fromJson(Map<String, dynamic> json) => _$PersonFromJson(json);

  Map<String, dynamic> toJson() => _$PersonToJson(this);
}