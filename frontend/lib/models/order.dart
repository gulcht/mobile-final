import 'package:store_app/models/customer.dart';
import 'package:store_app/models/employee.dart';
import 'package:store_app/models/Product.dart';

class Order {
  final int id;
  final Customer customer;
  final Employee employee;
  final Product product;
  final double orderTotal;
  final String createdAt;

  Order({
    required this.id,
    required this.customer,
    required this.employee,
    required this.product,
    required this.orderTotal,
    required this.createdAt,
  });

  factory Order.fromJson(Map<String, dynamic> json) {
    return Order(
      id: json['id'],
      customer: Customer.fromJson(json['customer']),
      employee: Employee.fromJson(json['employee']),
      product: Product.fromJson(json['product']),
      orderTotal: json['orderTotal'].toDouble(),
      createdAt: json['createdAt'],
    );
  }
}
