import { ApolloClient, InMemoryCache } from '@apollo/client';


const client = new ApolloClient({
    uri: '/catalog/graphql ',
    cache: new InMemoryCache()
  });
export default client