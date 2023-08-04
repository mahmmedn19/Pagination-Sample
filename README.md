# Pagination Example

This is an example of how to implement pagination in a Jetpack Compose application using the Paging 3 library. The example fetches data from a fake API with simulated delays and errors, demonstrating how to handle loading, error, and data states in the UI.

## Features

- Fetches data from a fake API with pagination support.
- Displays a list of items in a paginated manner.
- Shows loading indicators while data is being fetched.
- Handles errors and provides a retry mechanism."TODO"

## Demo

https://github.com/mahmmedn19/Pagination-Sample/assets/100851080/86872f72-3f01-4ddf-b6dd-797cbb64db78

## Libraries Used

- Jetpack Compose - A modern UI toolkit for building native UIs in Kotlin.
- Paging 3 - A library that helps load and display data in a paginated manner.
- Hilt - A dependency injection library for Android.



## Error Handling
### TODO 

In this example, if there is an error while fetching data, the app handles it gracefully by showing an error message in the UI. The error message provides a clickable behavior to trigger a retry, allowing the user to attempt fetching the data again.

When the data fetching encounters an error, the UI will display a user-friendly error message, such as "Error loading data. Tap to retry." The user can tap on the error message to trigger a retry, and the app will make another attempt to fetch the data.

The error handling logic is implemented in the `HomeScreen` composable. When the `LazyColumn` is displaying data, the `dataList.loadState` property provides information about the current state of data loading, which includes loading, error, and not loading (ready) states.


## License

This project is licensed under the MoNaser License - see the [LICENSE.md](LICENSE.md) file for details.

Feel free to clone, modify, and use this example in your own projects!

