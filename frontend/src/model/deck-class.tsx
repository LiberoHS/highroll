export type DeckIdentifier = "Demon Hunter" | "Druid" | "Hunter" | "Mage" | "Paladin" | "Priest" | "Rogue" | "Shaman" | "Warlock" | "Warrior";

export interface DeckClass {
    name: DeckIdentifier;
    key: string;
    imagePath: string;
}

export const deckClasses: DeckClass[] = [
    {
        name: "Demon Hunter",
        key: "DEMON_HUNTER",
        imagePath: "assets/class-demon-hunter.png",
    },
    {
        name: "Druid",
        key: "DRUID",
        imagePath: "assets/class-druid.png"
    },
    {
        name: "Hunter",
        key: "HUNTER",
        imagePath: "assets/class-hunter.png"
    },
    {
        name: "Mage",
        key: "MAGE",
        imagePath: "assets/class-mage.png"
    },
    {
        name: "Paladin",
        key: "PALADIN",
        imagePath: "assets/class-paladin.png"
    },
    {
        name: "Priest",
        key: "PRIEST",
        imagePath: "assets/class-priest.png"
    },
    {
        name: "Rogue",
        key: "ROGUE",
        imagePath: "assets/class-rogue.png"
    },
    {
        name: "Shaman",
        key: "SHAMAN",
        imagePath: "assets/class-shaman.png"
    },
    {
        name: "Warlock",
        key: "WARLOCK",
        imagePath: "assets/class-warlock.png"
    },
    {
        name: "Warrior",
        key: "WARRIOR",
        imagePath: "assets/class-warrior.png"
    }
];