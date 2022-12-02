import 'package:dooking/data/models/Person.dart';
import 'package:json_annotation/json_annotation.dart';

part 'address.g.dart';

@JsonSerializable()
class Address {
  String index;
  String country;
  String region;
  String district;
  String city;
  String street;
  String numberOfHouse;
  String corpus;
  String apartment;

  Address(this.index, this.country, this.region, this.district, this.city,
      this.street, this.numberOfHouse, this.corpus, this.apartment);

  factory Address.fromJson(Map<String, dynamic> json) => _$AddressFromJson(json);

  Map<String, dynamic> toJson() => _$AddressToJson(this);
}