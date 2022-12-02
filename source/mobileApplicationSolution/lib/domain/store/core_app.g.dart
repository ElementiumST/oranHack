// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'core_app.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic, no_leading_underscores_for_local_identifiers

mixin _$CoreApp on _CoreApp, Store {
  late final _$stateAppAtom = Atom(name: '_CoreApp.stateApp', context: context);

  @override
  StateApp get stateApp {
    _$stateAppAtom.reportRead();
    return super.stateApp;
  }

  @override
  set stateApp(StateApp value) {
    _$stateAppAtom.reportWrite(value, super.stateApp, () {
      super.stateApp = value;
    });
  }

  @override
  String toString() {
    return '''
stateApp: ${stateApp}
    ''';
  }
}
