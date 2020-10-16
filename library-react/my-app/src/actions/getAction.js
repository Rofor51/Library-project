import {GET_NUMBERS_IN_BASKET} from './types';


export const getNumbers = () => {
    return (dispatch) => {
        dispatch({
            type:GET_NUMBERS_IN_BASKET
        })
    }
}