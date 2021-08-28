import React from 'react';
import {Card, CardFooter, Heading, Image} from 'grommet';
import {DeckClass} from "../../model/deck-class";
import {useCurrentDecks} from "../../state/chosen-deck-context";

interface Props {
    deckClass: DeckClass;
}

export default function DeckClassCard(props: Props) {
    const { deckClass } = props;
    const [, deckActions] = useCurrentDecks();

    const updateClass = () => {
        deckActions.updateClass(deckClass);
        console.log(deckClass);
    };

    return (
        <Card height="small" width="small" background="light-1" onClick={updateClass}>
            <Image
                fit="cover"
                src={deckClass.imagePath}
            />
            <CardFooter pad={{horizontal: "small"}} background="light-2">
                <Heading level={5} margin="small" >{deckClass.name}</Heading>
            </CardFooter>
        </Card>
    )
}