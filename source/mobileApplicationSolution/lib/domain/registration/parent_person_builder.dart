import '../model/parent_domain_bean.dart';

class ParentPersonBuilder {
  late ParentDomainBean _buildableInstance;


  ParentPersonBuilder() {
    _buildableInstance = ParentDomainBean();
  }
  void setEmail(String email) {
    _buildableInstance.email = email;
  }
  void setFirstName(String firstName) {
    _buildableInstance.firstName = firstName;
  }
  void setSecondName(String secondName) {
    _buildableInstance.secondName = secondName;
  }
  void setLastname(String lastname) {
    _buildableInstance.lastname = lastname;
  }
  void setStatus(String status) {
    _buildableInstance.status = status;
  }
  void setCitizenCountry(String citizenCountry) {
    _buildableInstance.citizenCountry = citizenCountry;
  }
  void setpassportSeries(String passportSeries) {
    _buildableInstance.passportSeries = passportSeries;
  }
  void setpassportNumber(String passportNumber) {
    _buildableInstance.passportNumber = passportNumber;
  }
  void setDateOfGetting(DateTime dateOfGetting) {
    _buildableInstance.dateOfGetting = dateOfGetting;
  }
  void setBirthday(DateTime birthday) {
    _buildableInstance.birthday = birthday;
  }
  void setPassportGiver(String passportGiver) {
    _buildableInstance.passportGiver = passportGiver;
  }
  void setSnills(String snills) {
    _buildableInstance.snills = snills;
  }
  void setAddress(String address) {
    _buildableInstance.address = address;
  }
  ParentDomainBean build() {
    return _buildableInstance;
  }


}