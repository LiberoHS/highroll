import React from 'react';
import {storiesOf} from "@storybook/react";
import {Grommet} from "grommet";
import DeckClassForm from "../components/search/deck-class-form";

storiesOf('Search', module)
    .add('Class selection card', () => {
        return (
            <Grommet>
            </Grommet>
        )
    })
    .add('Class selection form', () => {
        return (
            <Grommet>
                <DeckClassForm/>
            </Grommet>
        )
    });