# Hack2017


Set-up tutorial:


0. Set up your working directory, SSH protocol, and GitHub account

    0a. Choose a folder for your workspace.
        This should be a local directory (not Google Drive, etc.)
        
    0b. Create a new folder in your workspace called "Hack2017".  
        This is your project folder or working directory.
        This is where we will set up our local git repository.
        
    0c. Set up your SSH protocol in Eclipse.
        In Eclipse, go to Windows > Preferences > General > Network Connections
        > SSH2 > Key Management.  Generate RSA Key.  Save Private Key.

    0d. Link your SSH key to your GitHub account.
        Go to your GitHut account settings.
        Click the "SSH and GPG keys" tab.
        Click "New SSH Key".  Copy and paste your key and save it.
        The key starts with "ssh-rsa" then several lines of characters.
        
    0e. Make sure you are listed as a collaborator on the project page.     
    
        
1. Install eGit

    1a. Help > Install New Software > Add...
    
    1b. Name: eGit
    
    1c. Location: http://download.eclipse.org/egit/updates
        I installed all three components, probably only the first is necessary.
        
    1d. Restart Eclipse.
    
    1e. Add Git Repositories and Git Staging to your workspace view.
    
        Window > Show View > Other > Git > Git Repositories
        
        Window > Show View > Other > Git > Git Staging


2.  Clone remote repository
    
    2a. Clone the remote repository
        In the Git Repositories view, click the button with the green arrow.
        
    2b. Paste the remote SSH URI given below:
        ssh://git@github.com/apatton090/Hack2017.git
        
    2c. Make sure the protocol is SSH and hit next.
        If you get an error, your SSH is probably not configured correctly.
    
    2d. Import all branches to the working directory (wherever you want your project folder to be.)
    
    2e. Viola!  You should see the repository appear in the Git Repositories view.
        You may still need to import the project to your Package Explorer to see the files.
    
    
3.  Make your first commit and push.

    3a. Edit README.md
        Make some changes and save the file.
                
    3b. Go to the Git Staging view.
        You should see README.md in "Unstaged Changes".
        
    3c. Hit the plus sign to add the file to staged changes.
    
    3d. Commit and push the changes to the remote repository.
        You will need to enter a commit message saying what your changes were.
    
    3e. Check on GitHub to verify your changes went through.
    
    
4.  Make your fetch and merge (pull)

    4a. Wait for someone to make changes to the README (or do so on another machine.)
                
    3b. In Git Repositories, go to Remotes and right click the one with the down arrow.
        This is your "fetch" remote for getting updates from the remote.
        The other is your "push" remote for pushing local changes to the remote.
        
    4c. Click fetch.
        You should see a window telling you what updates were fetched.
    
    3d. Open your README.  Nothing has changed!  What's wrong?
        You still need to merge your local repository with the changes you fetched from remote.
    
    3e. Right click the whole repository and click Merge.
        You can also get to the fetch and push remotes from this menu.
        
    3f. That's it!  Now you should see the changes in your README.


References:

https://stackoverflow.com/questions/21473308/integrating-eclipse-and-github

https://wiki.eclipse.org/EGit/User_Guide
