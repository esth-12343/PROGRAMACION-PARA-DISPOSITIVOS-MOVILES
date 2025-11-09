import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),
        backgroundColor: Colors.green,
        foregroundColor: Colors.white,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            const SizedBox(height: 20),
            const Center(
              child: Text(
                'Mis Pasatiempos Favoritos',
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Colors.green,
                ),
              ),
            ),
            const SizedBox(height: 30),
            
            // Hobby 1: Lectura
            _buildHobbyItem(
              icon: Icons.menu_book,
              title: 'Lectura',
              description: 'Me encanta leer libros de ciencia ficción y tecnología.',
              color: Colors.blue,
            ),
            
            const SizedBox(height: 20),
            
            // Hobby 2: Videojuegos
            _buildHobbyItem(
              icon: Icons.sports_esports,
              title: 'Videojuegos',
              description: 'Juego videojuegos de estrategia y aventuras en mi tiempo libre.',
              color: Colors.purple,
            ),
            
            const SizedBox(height: 20),
            
            // Hobby 3: Música
            _buildHobbyItem(
              icon: Icons.music_note,
              title: 'Música',
              description: 'Toco la guitarra y escucho diversos géneros musicales.',
              color: Colors.orange,
            ),
            
            const SizedBox(height: 20),
            
            // Hobby 4: Deportes
            _buildHobbyItem(
              icon: Icons.sports_basketball,
              title: 'Deportes',
              description: 'Practico baloncesto y salgo a correr los fines de semana.',
              color: Colors.red,
            ),
            
            const SizedBox(height: 30),
            
            // Sección adicional
            Container(
              padding: const EdgeInsets.all(16),
              decoration: BoxDecoration(
                color: Colors.green.shade50,
                borderRadius: BorderRadius.circular(12),
              ),
              child: const Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    'Otros Intereses:',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.green,
                      fontSize: 18,
                    ),
                  ),
                  SizedBox(height: 10),
                  Row(
                    children: [
                      Icon(Icons.code, color: Colors.green),
                      SizedBox(width: 10),
                      Text('Programación'),
                      SizedBox(width: 20),
                      Icon(Icons.movie, color: Colors.green),
                      SizedBox(width: 10),
                      Text('Cine'),
                    ],
                  ),
                  SizedBox(height: 10),
                  Row(
                    children: [
                      Icon(Icons.travel_explore, color: Colors.green),
                      SizedBox(width: 10),
                      Text('Viajar'),
                      SizedBox(width: 20),
                      Icon(Icons.restaurant, color: Colors.green),
                      SizedBox(width: 10),
                      Text('Cocina'),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildHobbyItem({
    required IconData icon,
    required String title,
    required String description,
    required Color color,
  }) {
    return Container(
      padding: const EdgeInsets.all(16),
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(12),
        boxShadow: [
          BoxShadow(
            color: Colors.grey.withOpacity(0.3),
            blurRadius: 4,
            offset: const Offset(0, 2),
          ),
        ],
      ),
      child: Row(
        children: [
          Container(
            padding: const EdgeInsets.all(12),
            decoration: BoxDecoration(
              color: color.withOpacity(0.2),
              shape: BoxShape.circle,
            ),
            child: Icon(icon, color: color, size: 30),
          ),
          const SizedBox(width: 15),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: color,
                  ),
                ),
                const SizedBox(height: 5),
                Text(
                  description,
                  style: const TextStyle(fontSize: 14),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}