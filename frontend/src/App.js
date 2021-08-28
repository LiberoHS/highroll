import './App.css';
import { Grommet } from 'grommet';
import React from "react";
import DeckClassForm from "./components/search/deck-class-form";
import CardSearchBar from "./components/search/card-search-bar";

function App() {
    return (
        <Grommet plain>
            <DeckClassForm/>
            <CardSearchBar/>
        </Grommet>
    );
}

export default App;
