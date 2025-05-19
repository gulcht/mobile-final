import 'package:flutter/material.dart';
import 'package:store_app/components/my_backbotton.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Theme.of(context).colorScheme.background,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
                decoration: BoxDecoration(
                  color: Theme.of(context).colorScheme.primary,
                  borderRadius: BorderRadius.circular(60),
                ),
                padding: const EdgeInsets.all(25),
                child: Icon(
                  Icons.store_mall_directory_rounded,
                  size: 200,
                  color: Theme.of(context).colorScheme.inversePrimary,
                )),
            const SizedBox(
              height: 50,
            ),
            const MyBackButton(),
          ],
        ),
      ),
    );
  }
}
