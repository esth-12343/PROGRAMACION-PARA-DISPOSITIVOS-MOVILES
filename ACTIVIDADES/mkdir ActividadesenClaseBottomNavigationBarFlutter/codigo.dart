import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'BottomNavigationBar Example',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;
  String _nombreUsuario = '';

  final List<Widget> _pages = [
    const Center(child: Text('Inicio', style: TextStyle(fontSize: 24))),
    const Center(child: Text('Usuarios', style: TextStyle(fontSize: 24))),
    const Center(child: Text('Configuración', style: TextStyle(fontSize: 24))),
    // La página de Perfil se construye dinámicamente
    Container(), // Placeholder, se reemplazará en build
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  void _editarPerfil() async {
    final nombre = await Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
    );
    if (nombre != null) {
      setState(() {
        _nombreUsuario = nombre;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    // Actualizar la página de Perfil con el estado actual
    _pages[3] = _buildPerfilPage();

    return Scaffold(
      appBar: AppBar(title: const Text('Ejemplo BottomNavigationBar')),
      body: _pages[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Inicio'),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: 'Usuarios'),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Config'),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: 'Perfil'),
        ],
      ),
    );
  }

  Widget _buildPerfilPage() {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          const Text('Perfil', style: TextStyle(fontSize: 24)),
          const SizedBox(height: 20),
          Text('Nombre: $_nombreUsuario', style: const TextStyle(fontSize: 18)),
          const SizedBox(height: 20),
          ElevatedButton(
            onPressed: _editarPerfil,
            child: const Text('Editar perfil'),
          ),
        ],
      ),
    );
  }
}

class EditarPerfilScreen extends StatefulWidget {
  const EditarPerfilScreen({super.key});

  @override
  State<EditarPerfilScreen> createState() => _EditarPerfilScreenState();
}

class _EditarPerfilScreenState extends State<EditarPerfilScreen> {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Editar perfil')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: const InputDecoration(labelText: 'Nombre'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pop(context, _controller.text);
              },
              child: const Text('Guardar'),
            ),
          ],
        ),
      ),
    );
  }
}