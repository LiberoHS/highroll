import './App.css';
import { Grommet } from 'grommet';
import React from "react";
import DeckClassForm from "./components/search/deck-class-form";
import CardSearchBar from "./components/search/card-search-bar";
import {ServiceProvider} from "./state/service-context";
import CardSearchResults from "./components/results/card-search-results";

function App() {
    return (
        <ServiceProvider>
            <Grommet plain>
                <DeckClassForm/>
                <CardSearchBar/>
                <CardSearchResults/>
            </Grommet>
        </ServiceProvider>
    );
}

export default App;
