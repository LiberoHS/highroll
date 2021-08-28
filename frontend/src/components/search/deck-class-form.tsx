import React from 'react';
import {Box, Grid, Heading} from "grommet";
import DeckClassCard from "./deck-class-card";
import {deckClasses} from "../../model/deck-class";
import styled from "styled-components";

const FormGrid = styled(Grid)`
    width: 50%;
    align-self: center;
`;

export default function DeckClassForm() {
    const renderClassCards = () => {
        return deckClasses.map((deck) => {
            return (
                <Box pad="small">
                    <DeckClassCard deckClass={deck}/>
                </Box>
            )
        })
    };

    return (
        <Box gap="small">
            <Heading level={2} alignSelf="center">Choose Your Class</Heading>
            <FormGrid columns="20%" responsive>
                {renderClassCards()}
            </FormGrid>
        </Box>
    );
}