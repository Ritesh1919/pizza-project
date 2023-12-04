
// src/App.js
import { useState } from 'react';


function Order() {
  const [orderID, setOrderID] = useState('');
  const [pizzaType, setPizzaType] = useState('Small');
  const [quantity, setQuantity] = useState('');
  const [address, setAddress] = useState('');
  const [totalPrice, setTotalPrice] = useState(0);

  const submitForm = () => {
    // Process form values as needed
    console.log('Order ID:', orderID);
    console.log('Pizza Type:', pizzaType);
    console.log('Quantity:', quantity);
    console.log('Address:', address);

    // Calculate total price (example: $80 per pizza)
    const calculatedPrice = 80 * parseInt(quantity, 10);
    setTotalPrice(calculatedPrice);
  };

  return (
    <div className="container mx-auto mt-10" style={{}} >
      <form className="bg-white p-8 rounded shadow-md" onSubmit={submitForm}>
        <div className="mb-6">
          <label htmlFor="orderID" className="block text-gray-600 text-sm font-medium mb-2" >
            Order ID:
          </label>
          <input
            type="text"
            id="orderID"
            className="form-input w-full border border-gray-300 rounded-md py-2 px-3"
            value={orderID}
            onChange={(e) => setOrderID(e.target.value)}
          />
        </div>

        <div className="mb-6">
          <label htmlFor="pizzaType" className="block text-gray-600 text-sm font-medium mb-2">
            Pizza Type:
          </label>
          <select
            id="pizzaType"
            className="form-select w-full border border-gray-300 rounded-md py-2 px-3"
            value={pizzaType}
            onChange={(e) => setPizzaType(e.target.value)}
          >
            <option value="Small">Small</option>
            <option value="Medium">Medium</option>
            <option value="Large">Large</option>
          </select>
        </div>

        <div className="mb-6">
          <label htmlFor="quantity" className="block text-gray-600 text-sm font-medium mb-2">
            Quantity:
          </label>
          <input
            type="number"
            id="quantity"
            className="form-input w-full border border-gray-300 rounded-md py-2 px-3"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
          />
        </div>

        <div className="mb-6">
          <label htmlFor="address" className="block text-gray-400 text-sm font-medium mb-2">
            Address:
          </label>
          <textarea
            id="address"
            className="form-textarea w-full border border-gray-300 rounded-md py-2 px-3"
            rows="1"
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
        </div>

        <div id="price" className="mb-6 text-center font-bold">
          <label htmlFor="totalPrice" className="block text-gray-600 text-sm font-medium mb-2">
            Total Price:
          </label>
          <span id="totalPrice">₹{totalPrice}</span>
        </div>
        <div className="mb-6 flex justify-center">
          <button type="button" className="bg-blue-500 text-white py-4 px-20 rounded-lg text-xl font-semibold hover:bg-blue-600 " onClick={submitForm}>
            Submit
          </button>
        </div>
      </form>
    </div>
  );
}

export default Order;
