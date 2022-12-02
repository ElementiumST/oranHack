import 'package:dooking/data/models/Passport.dart';
import 'package:json_annotation/json_annotation.dart';

part 'passport.g.dart';

@JsonSerializable()
class Passport {

  int series;
  int number;
  String dateOfGetting;
  String issueName;
  String isRussianPassport;

  Passport(this.series, this.number, this.dateOfGetting, this.issueName,
      this.isRussianPassport);

  factory Passport.fromJson(Map<String, dynamic> json) =>
      _$PassportFromJson(json);

  Map<String, dynamic> toJson() => _$PassportToJson(this);
}