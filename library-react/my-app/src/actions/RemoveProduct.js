import {REMOVE_PRODUCT} from './types'

export const clearProduct = (name) => {
    return(dispatch) => {
        dispatch({
            type:REMOVE_PRODUCT,
            name: name
        })
    }
}