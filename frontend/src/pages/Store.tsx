import { useEffect, useState } from "react";
import api from "../api/axios";

export default function Store() {

  const [productos, setProductos] = useState([]);
  const [cart, setCart] = useState<any[]>([]);

  useEffect(() => {
    api.get("/api/productos")
      .then(res => setProductos(res.data.content));
  }, []);

  const addToCart = (producto:any) => {

    const exist = cart.find(p => p.id === producto.id);

    if (exist) {
      setCart(
        cart.map(p =>
          p.id === producto.id
            ? { ...p, cantidad: p.cantidad + 1 }
            : p
        )
      );
    } else {
      setCart([...cart, { ...producto, cantidad: 1 }]);
    }
  };

  const total = cart.reduce(
    (sum, p) => sum + p.precio * p.cantidad, 0
  );

  const comprar = async () => {

  const body = {
  items: cart.map(p => ({
    productoId: p.id,
    cantidad: p.cantidad
  }))
};



    await api.post("/api/ventas", body);

    alert("Compra realizada ✅");

    setCart([]);
  };

  return (
    <div className="min-h-screen bg-slate-100 p-8">

      <h1 className="text-3xl font-bold mb-8 text-center">
        🛒 Tienda Online
      </h1>

      <div className="grid grid-cols-1 md:grid-cols-4 gap-6">

        {/* PRODUCTOS */}
        <div className="md:col-span-3 grid grid-cols-1 md:grid-cols-3 gap-6">

          {productos.map((p:any)=>(
            <div key={p.id}
              className="bg-white rounded-xl shadow p-5"
            >

              <h2 className="font-bold">{p.nombre}</h2>
              <p className="text-sm text-gray-500">{p.categoria}</p>

              <p className="mt-2 text-lg">${p.precio}</p>

              <button
                onClick={() => addToCart(p)}
                className="mt-4 w-full bg-green-600 hover:bg-green-700 text-white py-2 rounded"
              >
                Agregar
              </button>

            </div>
          ))}

        </div>

        {/* CARRITO */}
        <div className="bg-white rounded-xl shadow p-5">

          <h2 className="text-xl font-bold mb-4">Carrito</h2>

          {cart.length === 0 && (
            <p className="text-gray-500">Vacío</p>
          )}

          {cart.map(p => (
            <div key={p.id}
              className="flex justify-between mb-2 text-sm"
            >
              <span>{p.nombre}</span>
              <span>{p.cantidad}</span>
            </div>
          ))}

          <hr className="my-3" />

          <p className="font-bold">
            Total: ${total.toFixed(2)}
          </p>

          <button
            onClick={comprar}
            disabled={cart.length === 0}
            className="mt-4 w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded disabled:opacity-40"
          >
            Comprar
          </button>

        </div>

      </div>

    </div>
  );
}
