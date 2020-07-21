// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api',  // This URL while eclipse is running APIs in local development environment
  loginUrl: 'http://localhost:8080/login'  // Login URL while eclipse is running APIs in local development environment
  //apiUrl: 'http://localhost:8080/JanivService/api'  // This URL while APIs are deployed in local development environment 
  //loginUrl: 'http://localhost:8080/JanivService/api'  // Login URL while APIs are deployed in local development environment 
    
  //apiUrl: 'https://jsonplaceholder.typicode.com'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
