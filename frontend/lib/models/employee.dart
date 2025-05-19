class Employee {
  final int id;
  final String firstName;
  final String lastName;
  final String user;
  final String password;
  final String createdAt;

  Employee({
    required this.id,
    required this.firstName,
    required this.lastName,
    required this.user,
    required this.password,
    required this.createdAt,
  });

  factory Employee.fromJson(Map<String, dynamic> json) {
    return Employee(
      id: json['id'],
      firstName: json['firstName'],
      lastName: json['lastName'],
      user: json['user'],
      password: json['password'],
      createdAt: json['createdAt'],
    );
  }
}
