import React, {createContext, ReactNode, useContext} from 'react';
import {HearthstoneService} from "../services/hearthstone-service";

const service = {
    hearthstoneService: new HearthstoneService(),
};

export const ServiceProvider = (props: { children: ReactNode }) => {
    return <ServicesContext.Provider value={service}>{props.children}</ServicesContext.Provider>
};

export const ServicesContext = createContext(service);

export const useServices = () => {
    return useContext(ServicesContext);
};
