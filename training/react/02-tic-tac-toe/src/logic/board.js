import { WINNER_COMBOS } from "../constants"

export const checkWinnerFrom = (boarToCheck) => {
    // revisamos todas las combinaciones ganadoras
    // para ver si X u O ganó
    for (const combo of WINNER_COMBOS) {
        const[a, b, c] = combo
        if (boarToCheck[a] && boarToCheck[a] === boarToCheck[b] &&  boarToCheck[a] === boarToCheck[c]) {
        return boarToCheck[a]
        }
    }
    // No hay ganador
    return null
}

export const checkEndGame = (newBoard) => {
    return newBoard.every(square => square !== null)
}
