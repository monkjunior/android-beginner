# Lesson 3

#Application lifecycle
- Use oncreate to initialize app preference.
- Use onpause to save app preference.

Example1

- Create second activity.
- Main activity has button main, when press it, screen switch to second activity.
- Try activity as dialog theme.
- Application Life Cycle: on create, on pause, on destroy, on start, on resume.

Example2

- Change color theme activity.
- Use on pause to save color value then save to SharePreference.
- When you reload app, the previous color is still exist by using on create, on start or on resume.

Questions:

- What is an android application life cycle ?
- When i open an app, what and how functions will be called ?
- When i rotate an app, what and how functions will be called ?
- Differences between edit text have id and no id when using onRestoreInstanceState and onSaveInstanceState ? (save temporaty state)

