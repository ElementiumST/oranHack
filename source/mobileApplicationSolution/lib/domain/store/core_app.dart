import 'package:injectable/injectable.dart';
import 'package:mobx/mobx.dart';

import '../model/state_app.dart';

part 'core_app.g.dart';

@singleton
class CoreApp = _CoreApp with _$CoreApp;

abstract class _CoreApp with Store {

  @observable
  StateApp stateApp = NoAuthorized();
}