import 'package:flutter/material.dart';
import 'package:store_app/pages/orders_page.dart';
import 'package:store_app/theme/dark_mode.dart';
import 'package:store_app/theme/light_mode.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Demo',
        theme: lightMode,
        darkTheme: darkMode,
        home: OrderPage());
  }
}
