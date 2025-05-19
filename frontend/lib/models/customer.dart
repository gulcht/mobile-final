class Customer {
  final int id;
  final String firstName;
  final String lastName;
  final String password;
  final String createdAt;
  final String user;

  Customer({
    required this.id,
    required this.firstName,
    required this.lastName,
    required this.password,
    required this.createdAt,
    required this.user,
  });

  factory Customer.fromJson(Map<String, dynamic> json) {
    return Customer(
      id: json['id'],
      firstName: json['firstName'],
      lastName: json['lastName'],
      password: json['password'],
      createdAt: json['createdAt'],
      user: json['cuser'],
    );
  }
}
