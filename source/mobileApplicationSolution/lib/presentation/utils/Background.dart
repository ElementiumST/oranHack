import 'dart:ui';

import 'package:dooking/res/constants.dart';
import 'package:dooking/res/images.dart';
import 'package:flutter/material.dart';

class BackgroundScaffold extends StatelessWidget {
  BackgroundScaffold({Key? key, required this.child}) : super(key: key);

  Widget child;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        height: MediaQuery.of(context).size.height,
        width: MediaQuery.of(context).size.width,
        padding: const EdgeInsets.symmetric(horizontal: 40),
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage(MainBackgroundImage),
            fit: BoxFit.cover,
          ),
        ),
        child: Stack(
          alignment: Alignment.center,
          children: [
            Container(
              constraints: BoxConstraints(
                  minWidth: 0,
                  maxWidth: MAX_WIDTH,
                  minHeight: MediaQuery.of(context).size.height,
                  maxHeight: MediaQuery.of(context).size.height),
              child: child,
            ),
          ],
        ),
      ),
    );
  }
}
