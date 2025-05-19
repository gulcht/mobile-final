import 'package:flutter/material.dart';
import 'package:store_app/pages/orders_page.dart';

class MyBackButton extends StatelessWidget {
  const MyBackButton({super.key});
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
        onTap: () {
          Navigator.push(
              context, MaterialPageRoute(builder: (context) => OrderPage()));
        },
        child: Container(
          decoration: BoxDecoration(
            color: Theme.of(context).colorScheme.primary,
            shape: BoxShape.circle,
          ),
          padding: const EdgeInsets.all(10),
          child: Icon(
            Icons.exit_to_app_rounded,
            size: 40,
            color: Theme.of(context).colorScheme.inversePrimary,
          ),
        ));
  }
}
