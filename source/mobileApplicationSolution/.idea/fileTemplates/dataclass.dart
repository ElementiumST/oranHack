import 'package:dooking/data/models/${NAME}.dart';
import 'package:json_annotation/json_annotation.dart';

part '${NAME}.g.dart';

@JsonSerializable()
class ${NAME} {

  factory ${NAME}.fromJson(Map<String, dynamic> json) => _$${NAME}FromJson(json);
  
  Map<String, dynamic> toJson() => _$${NAME}ToJson(this);
}