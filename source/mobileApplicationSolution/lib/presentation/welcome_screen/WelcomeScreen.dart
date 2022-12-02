import 'package:dooking/presentation/utils/Background.dart';
import 'package:flutter/material.dart';

class WelcomeScreen extends StatelessWidget {
  const WelcomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return BackgroundScaffold(
      child: Container(
        color: Colors.amber,
      ),
    );
  }
}
