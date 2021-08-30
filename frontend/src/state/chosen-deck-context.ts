import {createStore, createHook, StoreActionApi} from 'react-sweet-state';
import {DeckClass} from "../model/deck-class";

interface State {
    currentClass: DeckClass | undefined;
}

type StoreApi = StoreActionApi<State>;
type Actions = typeof actions;

const initialState: State = {
    currentClass: undefined
};

const actions = {
    updateClass: (deck: DeckClass) => ({ setState }: StoreApi) => {
        setState({
            currentClass: deck
        });
    },
    getCurrentClass: () => ({ getState }: StoreApi) => {
        return getState().currentClass;
    },
    getClassKey: () => ({ getState }: StoreApi) => {
        const currentClass = getState().currentClass;
        return currentClass ? currentClass.key : "NEUTRAL";
    },
};

const Store = createStore<State, Actions>({
    initialState,
    actions
});

export const useCurrentClasses = createHook(Store);