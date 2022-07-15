import Header from "./components/Header";
import SalesCard from "./components/SalesCard";
import Footer from "./components/Footer";

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
      <Footer />
    </>
  )
}

export default App;
