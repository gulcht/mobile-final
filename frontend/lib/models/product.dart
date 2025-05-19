class Product {
  final int id;
  final String productName;
  final double price;
  final String createdAt;

  Product({
    required this.id,
    required this.productName,
    required this.price,
    required this.createdAt,
  });

  factory Product.fromJson(Map<String, dynamic> json) {
    return Product(
      id: json['id'],
      productName: json['productName'],
      price: json['price'].toDouble(),
      createdAt: json['createdAt'],
    );
  }
}
