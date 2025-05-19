import 'package:store_app/models/order.dart';
import 'dart:convert';

import 'package:http/http.dart' as http;

class OrderService {
  Future<List<Order>> getAllOrders() async {
    final response =
        await http.get(Uri.parse('http://localhost:8080/api/orders/get/all'));
    if (response.statusCode == 200) {
      final List<dynamic> jsonData = jsonDecode(response.body);
      return jsonData.map((itemJson) => Order.fromJson(itemJson)).toList();
    } else {
      throw Exception('Failed to load items by itemsetId');
    }
  }
}
