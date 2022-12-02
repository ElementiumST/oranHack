import 'package:dooking/res/constants.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class CustomTextField extends StatelessWidget {
  CustomTextField(
      {Key? key,
      this.text,
      this.height = HEIGHT,
      this.width,
      this.hintText,
      this.stroke = true,
      this.bottomMargin = 0.0,
      this.onChanged,
      this.isError = false,
      this.onFieldSubmitted,
      this.inputFormatters,
      this.onEditingComplete})
      : super(key: key);

  late String? text;
  late double height;
  late double? width;
  late String? hintText;
  late bool isError;
  late bool stroke;
  late double bottomMargin;
  late Function(String)? onChanged;
  late Function()? onEditingComplete;
  late Function(String)? onFieldSubmitted;
  late List<TextInputFormatter>? inputFormatters;

  @override
  Widget build(BuildContext context) {
    return Container(
      height: height,
      width: width,
      margin: EdgeInsets.only(bottom: bottomMargin),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(4),
        border: isError
            ? Border.all(color: Colors.redAccent)
            : stroke
                ? Border.all(color: Colors.white24, width: 2)
                : null,
        color: const Color(0x2442486B),
      ),
      child: Center(
        child: TextFormField(
          initialValue: text,
          onChanged: onChanged,
          autofocus: true,
          textInputAction: TextInputAction.newline,
          onFieldSubmitted: onFieldSubmitted,
          onEditingComplete: onEditingComplete,
          inputFormatters: inputFormatters,
          textAlign: TextAlign.center,
          minLines: 1,
          style: const TextStyle(
            color: Colors.white,
            fontWeight: FontWeight.w400,
          ),
          cursorColor: Colors.white,
          decoration: InputDecoration(
              border: InputBorder.none,
              enabledBorder: InputBorder.none,
              focusedBorder: InputBorder.none,
              contentPadding:
                  const EdgeInsets.symmetric(vertical: 8, horizontal: 8),
              hintText: hintText,
              hintMaxLines: 1,
              hintStyle: const TextStyle(
                  color: Colors.white12, fontWeight: FontWeight.w400)),
        ),
      ),
    );
  }
}
