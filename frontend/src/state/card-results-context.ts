import {createStore, createHook, StoreActionApi} from 'react-sweet-state';
import {HearthstoneCard} from "../model/hearthstone-card";

interface State {
    searchResults: HearthstoneCard[];
    hasNoResults: boolean;
}

type StoreApi = StoreActionApi<State>;
type Actions = typeof actions;

const initialState: State = {
    searchResults: [],
    hasNoResults: false
};

const actions = {
    updateResults: (cards: HearthstoneCard[] | undefined) => ({ setState }: StoreApi) => {
        setState({
            searchResults: cards ? cards : []
        });
    },
    getCards: () => ({ getState }: StoreApi) => {
        return getState().searchResults;
    },
    getCardIndex: (idx: number) => ({ getState }: StoreApi) => {
        return getState().searchResults[idx];
    },
    cannotFindResult: (bool: boolean) => ({ setState }: StoreApi) => {
        return setState({
            hasNoResults: bool
        });
    },
};

const Store = createStore<State, Actions>({
    initialState,
    actions
});

export const useCardResults = createHook(Store);