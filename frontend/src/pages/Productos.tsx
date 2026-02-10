import { useEffect, useState } from "react";
import api from "../api/axios";

export default function Productos() {

  const [productos, setProductos] = useState([]);

  useEffect(() => {
    api.get("/api/productos")
      .then(res => setProductos(res.data.content));
  }, []);

  return (
    <div>
      <h2>Productos</h2>

      {productos.map((p:any)=>(
        <div key={p.id}>
          {p.nombre} - ${p.precio} - Stock {p.stockActual}
        </div>
      ))}
    </div>
  );
}