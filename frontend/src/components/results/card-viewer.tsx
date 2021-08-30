import React from 'react';
import {Box, Grid, Image} from "grommet";
import {HearthstoneCard} from "../../model/hearthstone-card";

interface Props {
    card: HearthstoneCard
}

export default function CardViewer(props: Props) {
    const { card } = props;
    return (
        <Box>
            <Grid alignSelf="center" justify="center">
                <Image
                    fit="cover"
                    src={card.image}
                />
            </Grid>
        </Box>
    )
}