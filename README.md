# Hack2017

Set-up tutorial:

0. Set up your working directory and SSH protocol.
    0a. Choose a folder for your workspace.
        This should be a local directory (not Google Drive, etc.)
    0b. Create a new folder in your workspace called "Hack2017".  
        This is your project folder or working directory.
        This is where we will set up our local git repository.
    0c. Set up your SSH protocol in Eclipse.
        In Eclipse, go to Windows > Preferences > General > Network Connections
        > SSH2 > Key Management.
        Generate RSA Key.  Save Private Key.
    
1. Install eGit
    1a. Help > Install New Software > Add...
    1b. Name: eGit
    1c. Location: http://download.eclipse.org/egit/updates
        I installed all three components, probably only the first is necessary.
    1d. Restart Eclipse.

2.  Clone remote repository
    2a. Window > Show View > Other > Git > Git Repositories
        Click the button with the green arrow to clone the remote repository.
    2b. Paste the remote SSH URI given below:
        ssh://git@github.com/apatton090/Hack2017.git
    2c. Specify SSH as the protocol.
    2d. Import all branches to the working directory.
    2e. Test your setup by editing README.md, then commit and push to remote.

References:
https://stackoverflow.com/questions/21473308/integrating-eclipse-and-github
https://wiki.eclipse.org/EGit/User_Guide
