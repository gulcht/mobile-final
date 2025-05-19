import 'package:flutter/material.dart';
import 'package:store_app/components/my_drawer.dart';
import 'package:store_app/models/order.dart';
import 'package:store_app/service/order_service.dart';

class OrderPage extends StatelessWidget {
  final OrderService orderService = OrderService();

  OrderPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: MyDrawer(),
      backgroundColor: Theme.of(context).colorScheme.background,
      appBar: AppBar(
        title: const Text(
          "O R D E R S",
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.transparent,
        foregroundColor: Theme.of(context).colorScheme.inversePrimary,
        elevation: 0,
      ),
      body: FutureBuilder<List<Order>>(
        future: orderService.getAllOrders(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(
              child: CircularProgressIndicator(),
            );
          } else if (snapshot.hasError) {
            return Center(
              child: Text("Failed to load orders: ${snapshot.error}"),
            );
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(
              child: Text("No orders available"),
            );
          } else {
            final orders = snapshot.data;
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListView.builder(
                itemCount: orders!.length,
                itemBuilder: (context, index) {
                  return Card(
                    elevation: 0.1,
                    color: Theme.of(context).colorScheme.primary,
                    child: GestureDetector(
                      onTap: () {
                        _showOrderDetailsDialog(context, orders[index]);
                      },
                      child: ListTile(
                        leading: Container(
                          width:
                              50.0, // Set a fixed width for the leading widget
                          alignment: Alignment.center,

                          child: Text('${orders[index].id.toString()}'),
                        ),
                        title: Text(
                            'Customer: ${orders[index].customer.firstName}'),
                        subtitle: Text(
                            'Employee: ${orders[index].employee.firstName}'),
                        trailing: Text('฿${orders[index].orderTotal}'),
                      ),
                    ),
                  );
                },
              ),
            );
          }
        },
      ),
    );
  }

  void _showOrderDetailsDialog(BuildContext context, Order order) {
    showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          backgroundColor: Theme.of(context).colorScheme.background,
          title:
              Row(mainAxisAlignment: MainAxisAlignment.spaceBetween, children: [
            Text('Order Details'),
            Text('฿${order.orderTotal}'),
          ]),
          content: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            mainAxisSize: MainAxisSize.min,
            children: [
              Text('Order ID: ${order.id}'),
              Text(
                  'Customer: ${order.customer.firstName} ${order.customer.lastName}'),
              Text(
                  'Employee: ${order.employee.firstName} ${order.employee.lastName}'),
              Text('Product: ${order.product.productName}'),
              // Add more details as needed
            ],
          ),
          actions: [
            ElevatedButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.all(
                      Theme.of(context).colorScheme.background),
                  elevation: MaterialStateProperty.all(0),
                  shape: MaterialStateProperty.all(RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(10),
                    side: BorderSide(
                        color: Theme.of(context).colorScheme.background),
                  ))),
              child: Text(
                'Close',
                style: TextStyle(
                    color: Theme.of(context).colorScheme.inversePrimary),
              ),
            ),
          ],
        );
      },
    );
  }

  // Future<void> loadAllOrders() async {
  //   try {
  //     orders = await orderService.getAllOrders();
  //   } catch (e) {
  //     print("Failed to load orders: $e");
  //   }
  // }
}
