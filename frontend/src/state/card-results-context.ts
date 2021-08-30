import {createStore, createHook, StoreActionApi} from 'react-sweet-state';
import {HearthstoneCard} from "../model/hearthstone-card";

interface State {
    searchResults: HearthstoneCard[];
}

type StoreApi = StoreActionApi<State>;
type Actions = typeof actions;

const initialState: State = {
    searchResults: []
};

const actions = {
    updateResults: (cards: HearthstoneCard[]) => ({ setState }: StoreApi) => {
        setState({
            searchResults: cards
        });
    },
    getCards: () => ({ getState }: StoreApi) => {
        return getState().searchResults;
    },
    getCardIndex: (idx: number) => ({ getState }: StoreApi) => {
        return getState().searchResults[idx];
    },
};

const Store = createStore<State, Actions>({
    initialState,
    actions
});

export const useCardResults = createHook(Store);