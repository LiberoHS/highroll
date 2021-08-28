import {createStore, createHook, StoreActionApi} from 'react-sweet-state';
import {DeckClass} from "../model/deck-class";

interface State {
    currentDeck: DeckClass | undefined;
}

type StoreApi = StoreActionApi<State>;
type Actions = typeof actions;

const initialState: State = {
    currentDeck: undefined
};

const actions = {
    updateClass: (deck: DeckClass) => ({ setState }: StoreApi) => {
        setState({
            currentDeck: deck
        });
    },
    getCurrentClass: () => ({ getState }: StoreApi) => {
        return getState().currentDeck;
    },
};

const Store = createStore<State, Actions>({
    initialState,
    actions
});

export const useCurrentDecks = createHook(Store);