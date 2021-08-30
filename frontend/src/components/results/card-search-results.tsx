import React, {useEffect, useState} from 'react';
import {Box, Grid, List} from "grommet";
import {HearthstoneCard} from "../../model/hearthstone-card";
import {useCardResults} from "../../state/card-results-context";
import CardViewer from "./card-viewer";

export default function CardSearchResults() {
    const [selectedCard, setSelectedCard] = useState<HearthstoneCard>();
    const [searchResults, searchResultActions] = useCardResults();

    const updateSelectedCard = (idx?: number) => {
        if (idx === undefined) {
            return;
        }
        const card = searchResultActions.getCardIndex(idx);
        setSelectedCard(card);
    };

    const renderCardList = () => {
        return (
            <Box height="500px" gridArea="list" overflow="scroll">
                <List primaryKey="name" data={searchResults.searchResults} onClickItem={(e: {index?: number}) => updateSelectedCard(e.index)}/>
            </Box>
        )
    };

    const renderCardViewer = () => {
        return (
            <Box gridArea="viewer" gap="medium">
                {selectedCard !== undefined && <CardViewer card={selectedCard} />}
            </Box>
        )
    };

    return (
        <Box align="center" justify="center">
            <Grid
                rows={['xxsmall', 'xsmall']}
                columns={['large', 'medium']}
                gap="small"
                areas={[
                    { name: 'list', start: [0, 1], end: [0, 1] },
                    { name: 'viewer', start: [1, 1], end: [1, 1] },
                ]}
            >
                {renderCardList()}
                {renderCardViewer()}
            </Grid>
        </Box>
    )
}