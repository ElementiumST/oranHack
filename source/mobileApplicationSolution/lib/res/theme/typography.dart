import 'package:flutter/material.dart';

TextStyle defaultTextStyle(
    {double? size, FontWeight? fontWeight, Color? color}) {
  return TextStyle(
      color: color ?? Colors.white,
      fontSize: size,
      fontWeight: fontWeight,
      fontFamily: "Montserrat");
}
